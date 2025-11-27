package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class DatabaseCreator {

    private final ProductRepository productRepository;

    @PostConstruct
    public void createDatabase() {
        List<Product> productList = new ArrayList<>();
        Map<String, JsonNode> skuPairsById = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        //JSON beolvasasa
        try {
            JsonNode jsonNode = mapper.readTree(new File("src/main/java/com/example/demo/incompatible_feeds_products.json"));
            for (int i = 0; i < jsonNode.size(); i++) {
                skuPairsById.put(extractNumber(jsonNode.get(i).get("id").toString()), jsonNode.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //CSV beolvasasa
        Map<String, List<String>> pIdList = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(new File("src/main/java/com/example/demo/incompatible_feeds_products.csv"));
            CSVReader reader = new CSVReader(fileReader);

            List<String[]> allRecords = reader.readAll();
            for(int i = 1; i < allRecords.size(); i++){
                List<String> baseList = Arrays.stream(allRecords.get(i)).toList();
                pIdList.put(extractNumber(baseList.get(0)), baseList.subList(1, baseList.size()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Termekek letrehozasa
        for(String i : skuPairsById.keySet()){
            Product newProduct = new Product();
            JsonNode baseNode = skuPairsById.get(i);

            newProduct.setHunProductName(pIdList.get(i).get(0));
            newProduct.setSku(i);
            newProduct.setEnglishProductName(baseNode.get("name").asText(null));
            newProduct.setGrossPriceHuf(Integer.valueOf(pIdList.get(i).get(1).replaceAll(" ", "")));
            newProduct.setNetPriceHuf(!baseNode.get("netPrice").asText().equals("null") ?  Integer.valueOf(baseNode.get("netPrice").toString()) : null);
            newProduct.setCurrency(baseNode.get("currency").asText(null));
            newProduct.setStockQuantity(Integer.valueOf(pIdList.get(i).get(2).replaceAll(" ", "")));
            newProduct.setVatRate(!baseNode.get("vatRate").asText().equals("null") ? Double.valueOf(baseNode.get("vatRate").toString()) : null);
            newProduct.setQuantityAvailable(!baseNode.get("quantityAvailable").asText().equals("null") ? Integer.valueOf(baseNode.get("quantityAvailable").toString()) : null);
            newProduct.setEan(baseNode.get("ean").asText(null));
            newProduct.setBrand(baseNode.get("manufacturer").asText(null));

            productList.add(newProduct);
        }

        for(String i : pIdList.keySet()){
            boolean isNew = productList.stream().filter(product -> String.valueOf(product.getSku()).equals(i)).count() == 0;

            if (isNew){
                Integer grossPrice =  pIdList.get(i).get(1) != "" ? Integer.valueOf(pIdList.get(i).get(1).replaceAll(" ", "")) : null;
                Integer stockQuantity = pIdList.get(i).get(2) != "" ? Integer.valueOf(pIdList.get(i).get(1).replaceAll(" ", "")) : null;

                Product newProduct = new Product();
                newProduct.setSku(i);
                newProduct.setHunProductName(pIdList.get(i).get(0));
                newProduct.setGrossPriceHuf(grossPrice);
                newProduct.setStockQuantity(stockQuantity);
                newProduct.setBrand(pIdList.get(i).get(3));
            }
        }

        //Arak ellenorzese
        for (Product product: productList){
            if (product.getNetPriceHuf() == null && product.getGrossPriceHuf() != null) {
                product.setNetPriceHuf(grossPriceToNettPrice(product.getGrossPriceHuf()));
            } else if (product.getNetPriceHuf() != null && product.getGrossPriceHuf() == null) {
                product.setGrossPriceHuf(nettPriceToGrossPrice(product.getNetPriceHuf()));
            }
        }

        productRepository.saveAll(productList);
    }

    //segito methodok
    public String extractNumber(String baseText) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(baseText);

        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    //Atvaltok
    public Integer nettPriceToGrossPrice(Integer netPrice) {
        return (int) (netPrice * 1.27);
    }

    public Integer grossPriceToNettPrice(Integer grossPrice) {
        return (int) Math.round(grossPrice / 1.27);
    }
}

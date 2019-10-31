package ru.itpark;

import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;
import ru.itpark.service.ProductService;


public class Main {
    public static void main(String[] args) {
        final ProductService service = new ProductService(new ProductRepository());


        service.addProduct(new Product(0, "SSD накопитель 240ГБ, 2.5\", " +
                "SATA III, Toshiba TR200, THN-TR20Z2400U8",
                "SSD накопитель 240ГБ, 2.5\", " +
                        "SATA III, Toshiba TR200, THN-TR20Z2400U8", 5,
                "https://www.ulmart.ru/goods/4549536#tab-reviews", "Выгодная покупка",
                240, "https://p.fast.ulmart.ru/p/big/441.jpg",
                "Благодаря 64-слойной структуре с вертикальной укладкой, " +
                        "технология Toshiba BiCS FLASH обеспечивает более высокую пропускную способность, " +
                        "выносливость, производительность и эффективность в одном и том же месте," +
                        " обеспечивая передовые технологии хранения.", 2450, "Комплектующие для ПК"));
        service.addProduct(new Product(0, "SSD накопитель 360ГБ, 2.5\", " +
                "SATA III, Toshiba TR360, THN-TR20Z2400U8",
                "SSD накопитель 360ГБ, 2.5\", " +
                        "SATA III, Toshiba TR200, THN-TR20Z2400U8", 4,
                "https://www.ulmart.ru/goods/4549536#tab-reviews", "Выгодная покупка",
                240, "https://p.fast.ulmart.ru/p/big/441.jpg",
                "Благодаря 64-слойной структуре с вертикальной укладкой, " +
                        "технология Toshiba BiCS FLASH обеспечивает более высокую пропускную способность, " +
                        "выносливость, производительность и эффективность в одном и том же месте," +
                        " обеспечивая передовые технологии хранения.", 3200, "Комплектующие для ПК"));
        service.addProduct(new Product(0, "HDD накопитель 580ГБ, 2.5\", " +
                "SATA III, HITACHI", "HDD накопитель 580ГБ, 2.5\", SATA III, HITACHI", 3,
                "https://www.ulmart.ru/goods/4549536#tab-reviews", "Выгодная покупка",
                240, "https://p.fast.ulmart.ru/p/big/44.jpg",
                "Благодаря 64-слойной структуре с вертикальной укладкой, " +
                        "технология Toshiba BiCS FLASH обеспечивает более высокую пропускную способность, " +
                        "выносливость, производительность и эффективность в одном и том же месте," +
                        " обеспечивая передовые технологии хранения.", 1800, "Жесткие диски"));
//        System.out.println(service.getSortedByPriceDesc());
        //  System.out.println(service.getSortedByName());
        service.displayByCategory("Комплектующие для ПК");
//        System.out.println(service.getSortedByRatingAsc());
//        service.searchByName("SSD");

//        service.deleteProduct(1);
//        service.display();
    }
}

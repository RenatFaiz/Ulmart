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
                        " обеспечивая передовые технологии хранения.",
                2450, "Комплектующие для ПК"));

        service.addProduct(new Product(0, "микроволновая печь V-HOME P70H20L-KH",
                "микроволновая печь V-HOME P70H20L-KH, 20 л", 4,
                "https://www.ulmart.ru/goods/4457582#tab-reviews", "none",
                20, "https://p.fast.ulmart.ru/p/big/445/44575/4457582.jpg",
                "Микроволновая печь V-HOME P70H20L-KH имеет мощность микроволн 700 Вт и вместительный " +
                        "объем рабочей камеры, что обеспечивает быстрый разогрев даже большой порции пищи. " +
                        "Механический таймер позволяет установить желаемое время подогрева, а звуковой сигнал " +
                        "оповестит о готовности блюда.",
                3450, "Бытовая техника"));

        service.addProduct(new Product(0, "жесткий диск HDD 500ГБ, Seagate BarraCuda, ST500DM009",
                "жесткий диск HDD 500ГБ, 3.5\", 7200об/мин, 32МБ, SATA 6 Гбит/с, Seagate BarraCuda," +
                        " ST500DM009",
                3, "https://www.ulmart.ru/goods/3999806#tab-reviews", "none",
                500, "https://p.fast.ulmart.ru/p/big/399/39998/3999806.jpg",
                "Увеличьте емкость вашего ПК с помощью накопителя Seagate BarraCuda ST500DM009, " +
                        "предназначенного специально для настольных и моноблочных компьютеров.",
                2770, "Комплектующие для ПК"));

        System.out.println(service.getSortedByPriceAsc());
        System.out.println(service.getSortedByPriceDesc());
        System.out.println(service.getSortedByName());
        System.out.println(service.getSortedByRatingAsc());

        System.out.println(service.displayByCategory("Комплектующие для ПК"));
        System.out.println(service.searchByName("SSD"));
        service.deleteProduct(1);
        System.out.println(service.displayAll());
    }
}

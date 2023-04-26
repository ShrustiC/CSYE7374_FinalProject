package org.csye7374;

import org.csye7374.Item.*;
import org.csye7374.billing.MemberDiscount;
import org.csye7374.billing.SpecialDiscount;
import org.csye7374.order.*;
import org.csye7374.store.OnlineStore;
import org.csye7374.store.OnlineStoreAPI;
import org.csye7374.store.Store;
import org.csye7374.store.StoreAPI;
import org.csye7374.utils.AdvancedCalculator;
import org.csye7374.utils.AdvancedCalculatorAPI;
import org.csye7374.utils.BasicCalculator;
import org.csye7374.utils.CalculatorAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        System.out.println("App started ....");
        demoState();
        demoItemSingletonFactoryAndBuilder();
        demoBridge();
        demoStrategy();
        demoDecorator();
        demoCompositeAdapter();
        System.out.println("App exit ....");
    }

    private static void demoState() {
        System.out.println("-----------------------State-----------------------");
        //State Pattern change the State if Item is not available
        Item item = new Item( 10.99,"book");
        Item item1= new Item( 10.99,"pen");

        Inventory inventory = new Inventory();

        inventory.addItem(item);

        if (inventory.isItemAvailable(item1)) {
            System.out.println(item1.getName() + " is available for purchase.");
        } else {
            System.out.println(item1.getName() + " is out of stock.");
        }
        System.out.println("-----------------------END-----------------------");
    }

    private static void demoItemSingletonFactoryAndBuilder() {
        System.out.println("-----------------------Factory, Singleton and Builder-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Apple (x6)").setPrice(3.99);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Eggs 18").setPrice(5.49);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));
        builder.setName("Gatorade (x6)").setPrice(8.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Chocolate Box").setPrice(10.0);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));
        items.stream().forEach(i -> {System.out.println(i);});
        System.out.println("-----------------------END-----------------------");
    }

    private static void demoBridge() {
        System.out.println("-----------------------Bridge-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Bread loaf").setPrice(5.79);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Coke cans (x8)").setPrice(7.69);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Tropical Fruit Punch Drink, 59 fl oz Carton").setPrice(2.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Gatorade (x6)").setPrice(8.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        System.out.println("Items bought -");
        items.stream().forEach(i -> {System.out.println(i);});
        List<Double> prices = items.stream().map(i -> i.getPrice()).collect(Collectors.toList());
        System.out.print("Price list - ");
        System.out.println(prices);

        CalculatorAPI calculator = new BasicCalculator();
        StoreAPI physicalStore = new Store(calculator);
        System.out.println(String.format("Total Price when bought via Physical store and basic calculator = %f",
                physicalStore.sumTotal(prices)));

        AdvancedCalculatorAPI advancedCalculator = new AdvancedCalculator();
        OnlineStoreAPI onlineStore = new OnlineStore(advancedCalculator);
        System.out.println(String.format("Total Price when bought via Online store and advanced calculator = %f",
                onlineStore.sumTotal(prices)));

        System.out.println("-----------------------END-----------------------");
    }

    private static void demoStrategy() {
        System.out.println("-----------------------Bridge-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Bread loaf").setPrice(5.79);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Coke cans (x8)").setPrice(7.69);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Chocolate Box").setPrice(10.0);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Creamy Peanut Butter 40 oz").setPrice(5.92);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        System.out.println("Items bought -");
        items.stream().forEach(i -> {System.out.println(i);});
        List<Double> prices = items.stream().map(i -> i.getPrice()).collect(Collectors.toList());
        System.out.print("Price list - ");
        System.out.println(prices);

        AdvancedCalculatorAPI advancedCalculator = new AdvancedCalculator();
        OnlineStoreAPI onlineStore = new OnlineStore(advancedCalculator);
        System.out.println(String.format("Total Price with zero discount = %f", onlineStore.sumTotal(prices)));
        onlineStore.setStrategy(new MemberDiscount());
        System.out.println(String.format("Total Price with member discount (10%%) = %f", onlineStore.sumTotal(prices)));
        onlineStore.setStrategy(new SpecialDiscount());
        System.out.println(String.format("Total Price with special discount (20%%) = %f", onlineStore.sumTotal(prices)));
        System.out.println("-----------------------END-----------------------");
    }

    private static void demoDecorator() {
        System.out.println("-----------------------Decorator-----------------------");
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Chocolate Box").setPrice(10.0);
        ItemAPI chocolateBox = ItemFactoryEagerSingleton.getInstance().getObject(builder);
        System.out.println(chocolateBox);
        System.out.println("Item after gift wrap -");
        chocolateBox = new GiftWrapDecorator(chocolateBox);
        System.out.println(chocolateBox);
        System.out.println("Item after adding decorative ribbon -");
        chocolateBox = new RibbonDecorator(chocolateBox);
        System.out.println(chocolateBox);
        System.out.println("-----------------------END-----------------------");
    }

    private static void demoCompositeAdapter() {
        System.out.println("-----------------------Decorator-----------------------");
        ItemBuilder builder = new ItemBuilder();
        SingleStoreOrderBuilder walmartOrderBuilder = new SingleStoreOrderBuilder();
        walmartOrderBuilder.addItem(builder.setName("Chocolate Box").setPrice(10.0).build())
                        .addItem(builder.setName("Creamy Peanut Butter 40 oz").setPrice(5.92).build())
                                .addItem(builder.setName("Coke cans (x8)").setPrice(7.69).build())
                                        .setName("Walmart Order");
        SingleStoreOrderBuilder wholeFoodsOrderBuilder = new SingleStoreOrderBuilder();
        wholeFoodsOrderBuilder.addItem(builder.setName("Apple (x6)").setPrice(3.99).build())
                        .addItem(builder.setName("Tropical Fruit Punch Drink, 59 fl oz Carton").setPrice(2.49).build())
                                .setName("Whole Foods order");

        MultiStoreOrderBuilder multiStoreOrder = new MultiStoreOrderBuilder();
        multiStoreOrder.addOrder(wholeFoodsOrderBuilder.build())
                        .addOrder(walmartOrderBuilder.build())
                                .setName("Multi-store order");

        OrderComponentAPI order = new MultiStoreOrderComponentFactory().getObject(multiStoreOrder);
        System.out.println(order);
        System.out.println("-----------------------END-----------------------");
    }
}

/*
facade --
state -- check order state
command -- we will skip
prototype
observer --
*/

// Item enum check them

//item types need to check
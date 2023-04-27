package org.csye7374;

import org.csye7374.Customer.Customer;
import org.csye7374.Item.*;
import org.csye7374.billing.*;
import org.csye7374.order.*;
import org.csye7374.store.*;
import org.csye7374.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("App started ....");
        demoState();
        demoItemSingletonFactoryAndBuilder();
        demoBridge();
        demoStrategy();
        demoDecorator();
        demoCompositeAdapter();
        demoFacade();
        demoObserver();
		demoPrototype();		
        System.out.println("App exit ....");
    }

    private static void demoState() {
        System.out.println("-----------------------State-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        Inventory inventory = new Inventory();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Oranges (x12)").setPrice(3.99);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Onions").setPrice(5.49);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));
        builder.setName("Pepsi (x6)").setPrice(8.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Oats").setPrice(10.0);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));
        items.stream().forEach(i -> {inventory.addItem(i);});
        inventory.isItemAvailable(items.get(1));
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
        System.out.println("-----------------------Strategy-----------------------");
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

    private static void demoFacade() {
        System.out.println("-----------------------Facade-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        Inventory inventory = new Inventory();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Bananas (x6)").setPrice(4.99);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Protein Bars (x12)").setPrice(20.49);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));
        builder.setName("Milk (x2)").setPrice(10.99);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Ice Cream").setPrice(5.99);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));
        items.stream().forEach(i -> {inventory.addItem(i);});
        inventory.isItemAvailable(items.get(1));
        System.out.println("-----------------------END-----------------------");
    }

    private static void demoObserver(){
        System.out.println("-----------------------Observer-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Coke cans (x8)").setPrice(7.69);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Tropical Fruit Punch Drink, 59 fl oz Carton").setPrice(2.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Gatorade (x6)").setPrice(8.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));

        DiscountsAndOffers offers = new DiscountsAndOffers();
        Customer customer1 = new Customer("Davis");
        Customer customer2 = new Customer("Lily");

        offers.register(customer1);
        offers.register(customer2);

        offers.addDiscount(items.get(1), 10.0);
        offers.removeDiscount(items.get(1));

        offers.unregister(customer2);

        offers.addDiscount(items.get(2), 20.0);

        System.out.println("-------------------------END-------------------------");
    }
    
    private static void demoPrototype() throws CloneNotSupportedException {
        System.out.println("-----------------------Prototype-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        ProtoClone protoclone = new ProtoClone();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Twix (x2)").setPrice(7.99);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Maggie 6").setPrice(5.49);
        items.add(ItemFactoryLazySingleton.getInstance().getObject(builder));  
        System.out.println("-----------------------END-----------------------");
    }
}

// prototype - need to check

// Item enum check them

//item types need to check
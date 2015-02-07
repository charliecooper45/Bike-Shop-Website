package test;

import hibernate.classes.Basket;
import hibernate.classes.Bike;
import hibernate.classes.BikeModel;
import hibernate.classes.BikeShopOrder;
import hibernate.classes.Brand;
import hibernate.classes.Payment;
import hibernate.classes.User;
import hibernate.utils.HibernateUtilities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		// // TODO: delete this
		Session session = HibernateUtilities.getSessionFactory().openSession();
		// Transaction tx = session.beginTransaction();
		//
		// Brand brand = null;
		// // insert brands
		// for (int i = 1; i <= 10; i++) {
		// brand = new Brand("Brand " + i);
		// session.save(brand);
		// }
		//
		// // insert bike models
		// for (int i = 1; i <= 10; i++) {
		// BikeModel bikeModel = new BikeModel("Bike Model " + i, "£1000",
		// brand, null);
		// session.save(bikeModel);
		// }
		// tx.commit();
		//
		// session.clear();
		// Query namedQuery = session.getNamedQuery(Brand.QUERY_BY_ID);
		// namedQuery.setParameter("id", 10);
		// brand = (Brand) namedQuery.uniqueResult();
		// System.out.println("Found brand: " + brand.getId());
		//
		// List<BikeModel> bikeModels = brand.getBikeModels();
		// System.out.println("Brand " + brand.getId() + " has " +
		// bikeModels.size() + " bike models");

		// tx = session.beginTransaction();
		// session.delete(brand);
		// tx.commit();

		// tx = session.beginTransaction();
		// User user = new User("charliecooper98@gmail.com", "password",
		// "Charlie", "Cooper");
		// session.save(user);
		// tx.commit();
		//
		// tx = session.beginTransaction();
		// Bike bike = new Bike("1000123", bikeModels.get(0));
		// session.save(bike);
		// tx.commit();

		// session.clear();
		// tx = session.beginTransaction();
		// session.delete(bikeModels.get(0));
		// tx.commit();

		// add bike to basket
		// tx = session.beginTransaction();
		// basket.addBike(bike);
		// tx.commit();

		// add demo payment
		// tx = session.beginTransaction();
		// Payment payment = new Payment("10052321343538736", new Date(), user,
		// true);
		// session.save(payment);
		// tx.commit();
		//
		// tx = session.beginTransaction();
		// Set<Bike> bikes = new HashSet<>();
		// bikes.add(bike);
		// BikeShopOrder order = new BikeShopOrder(user, bikes, payment);
		// session.save(order);
		// tx.commit();

		// tx = session.beginTransaction();
		// Basket basket = new Basket(user);
		// basket.addBike(bike);
		// session.save(basket);
		// tx.commit();
		//
		// tx = session.beginTransaction();
		// session.delete(basket);
		// tx.commit();

		Transaction tx = session.beginTransaction();
		User user = new User("c@gmail.com", "password", "Charlie", "Cooper");
		Basket basket = new Basket(user);
		Brand brand = new Brand("Brand 1");
		BikeModel bikeModel = new BikeModel("Model 1", "200", brand, null);
		Bike bike = new Bike("1", bikeModel);
		Payment payment = new Payment("111", new Date(), user, true);
		Set<Bike> bikes = new HashSet<>();
		bikes.add(bike);
		BikeShopOrder order = new BikeShopOrder(user, bikes, payment);
		
		session.save(user);
		session.save(basket);
		session.save(brand);
		session.save(bikeModel);
		session.save(bike);
		session.save(payment);
		session.save(order);
		
		basket.addBike(bike);

		tx.commit();
		
		tx = session.beginTransaction();
		basket.removeBike(bike.getSerialNumber());
		basket.removeUser();
		session.delete(basket);
		
		tx.commit();
	}
}

package components.dao;

import components.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class ProductDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Product> index() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> stock = session.createQuery("select p from Product p", Product.class)
                .getResultList();
        return stock;
    }

    @Transactional(readOnly = true)
    public Product show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Transactional
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Transactional
    public void update(int id, Product updatedProduct) {
        Session session = sessionFactory.getCurrentSession();
        Product productToBeUpdated = session.get(Product.class, id);

        productToBeUpdated.setName(updatedProduct.getName());
        productToBeUpdated.setDescription(updatedProduct.getDescription());
        productToBeUpdated.setCategory(updatedProduct.getCategory());
        productToBeUpdated.setPrice(updatedProduct.getPrice());
        productToBeUpdated.setCount(updatedProduct.getCount());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Product.class, id));
    }
}
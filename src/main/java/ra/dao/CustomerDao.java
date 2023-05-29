package ra.dao;

import ra.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerDao implements ICustomerDao{
    @PersistenceContext
    private EntityManager en;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = en.createQuery("Select c from Customer  c",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = en.createQuery("select c from Customer c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return (Customer) query.getResultList();

        } catch (NoResultException e) {
            return null;
        }

    }
    @Override
    public void save(Customer customer) {
        if (customer.getId()!= null){
            en.merge(customer);
        }else {
            en.persist(customer);
        }

    }
    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            en.remove(customer);
        }

    }
}

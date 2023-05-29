package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.ICustomerDao;
import ra.model.Customer;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerDao customerDao;
    @Override
    public List<Customer> findAll() {

        return  customerDao.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerDao.remove(id);
    }
}

package com.example.data.repository;

import com.example.data.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PaymentRepository {
    @PersistenceContext
    private Session session;

    public void save(Payment payment) {
        session.save(payment);
    }

    public List<Payment> getPaymentsList(int count) {
        return session.createQuery("select p FROM Payment p ORDER BY p.id ASC", Payment.class).setMaxResults(count).getResultList();
    }
}

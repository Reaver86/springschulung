package io.crowdcode.speedbay.auction.repository.jpa;

import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by SU00079 on 30.09.2016.
 */
@Profile("jpa")
@Repository
public class AuctionRepositoryJpaBean implements AuctionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Auction> find(Long auctionId) {
        return Optional.ofNullable(em.find(Auction.class, auctionId));
    }

    @Override
    public Auction findOne(Long auctionId) {
        return em.find(Auction.class, auctionId);
    }

    @Override
    public List<Auction> findAll() {
        Query query = em.createQuery("SELECT a FROM Auction a");
        return (List<Auction>) query.getResultList();
    }

    @Override
    public Auction save(Auction auction) {
        em.persist(auction);
        return auction;
    }
}

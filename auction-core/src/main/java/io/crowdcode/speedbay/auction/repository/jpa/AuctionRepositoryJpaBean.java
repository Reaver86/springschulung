package io.crowdcode.speedbay.auction.repository.jpa;

import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
@Profile("jpa")
public class AuctionRepositoryJpaBean implements AuctionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Auction> find(Long auctionId) {
        return Optional.ofNullable(findOne(auctionId));
    }

    @Override
    public Auction findOne(Long auctionId) {
        return em.find(Auction.class, auctionId);
    }

    @Override
    public List<Auction> findAll() {
        String ql = "SELECT a FROM Auction a JOIN FETCH a.bids";
        TypedQuery<Auction> query = em.createQuery(ql, Auction.class);
        return query.getResultList();
    }

    @Override
    public Auction save(Auction auction) {
        em.persist(auction);
        return auction;
    }
}

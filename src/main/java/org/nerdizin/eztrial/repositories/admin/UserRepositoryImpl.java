package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.AbstractCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends AbstractCustomRepository implements UserRepositoryCustom {

    @Override
    public Page<User> findAll(final Pageable pageable, final UserFilter userFilter) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<User> cq = cb.createQuery(User.class);
        final Root<User> root = cq.from(User.class);

        final TypedQuery<User> query = em.createQuery(cq.select(root)
                .where(getFilterPredicates(cb, root, userFilter))
                .orderBy(getOrder(pageable, root, cb)))
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

        final List<User> users = query.getResultList();
        return new PageImpl<>(users, pageable, countAll(userFilter));
    }

    @Override
    public long countAll(final UserFilter userFilter) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
        final Root<User> rootCount = cqCount.from(User.class);

        final TypedQuery<Long> queryCount = em.createQuery(
                cqCount.select(cb.count(rootCount))
                       .where(getFilterPredicates(cb, rootCount, userFilter)));
        return queryCount.getSingleResult();
    }

    private Predicate[] getFilterPredicates(final CriteriaBuilder cb,
                                            final Root<User> root,
                                            final UserFilter userFilter) {

        final List<Predicate> predicates = new ArrayList<>();

        if (userFilter.hasUserName()) {
            predicates.add(cb.like(root.get("userName"), "%" + userFilter.getUserName() + "%"));
        }
        if (userFilter.getActive() != null) {
            predicates.add(cb.equal(root.get("active"), userFilter.getActive()));
        }

        return predicates.toArray(new Predicate[0]);
    }
}

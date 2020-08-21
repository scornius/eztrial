package org.nerdizin.eztrial.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@Transactional
public abstract class AbstractCustomRepository {

    @PersistenceContext
    protected EntityManager em;

    protected Order[] getOrder(final Pageable pageable,
                               final Root<?> root,
                               final CriteriaBuilder cb) {

        final List<Order> result = new ArrayList<>();
        final Iterator<Sort.Order> it = pageable.getSort().iterator();
        it.forEachRemaining(order -> {
            final Path<Object> orderProperty = root.get(order.getProperty());
            if (order.isAscending()) {
                result.add(cb.asc(orderProperty));
            } else {
                result.add(cb.desc(orderProperty));
            }
        });

        return result.toArray(new Order[0]);
    }

    protected Collection<List<Long>> chunkList(final List<Long> input, final int chunkSize) {
        final AtomicInteger counter = new AtomicInteger();
        return input.stream().collect(Collectors.groupingBy(aLong -> counter.getAndIncrement() / chunkSize)).values();
    }

    protected void addDateFieldGreaterEqual(final List<Predicate> predicates,
                                            final CriteriaBuilder cb,
                                            final Expression<LocalDateTime> dateExpression,
                                            final LocalDateTime filterDate) {
        predicates.add(cb.or(
                cb.isNull(dateExpression),
                cb.greaterThanOrEqualTo(dateExpression, filterDate)
        ));
    }

    protected void addDateFieldLess(final List<Predicate> predicates,
                                            final CriteriaBuilder cb,
                                            final Expression<LocalDateTime> dateExpression,
                                            final LocalDateTime filterDate) {
        predicates.add(cb.or(
                cb.isNull(dateExpression),
                cb.lessThan(dateExpression, filterDate.plusDays(1).truncatedTo(ChronoUnit.DAYS))
        ));
    }
}

package kitchenpos.order.application;

import java.util.List;
import kitchenpos.common.exception.InvalidMenuNumberException;
import kitchenpos.common.exception.NotExistException;
import kitchenpos.menu.repository.MenuRepository;
import kitchenpos.table.domain.OrderTable;
import kitchenpos.table.repository.OrderTableRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    private final OrderTableRepository orderTableRepository;
    private final MenuRepository menuRepository;

    public OrderValidator(OrderTableRepository orderTableRepository,
                          MenuRepository menuRepository) {
        this.orderTableRepository = orderTableRepository;
        this.menuRepository = menuRepository;
    }

    public void validateOrderMenuCount(List<Long> orderMenuIds) {
        if (orderMenuIds.size() != menuRepository.countByIdIn(orderMenuIds)) {
            throw new InvalidMenuNumberException();
        }
    }

    public Long existMenuId(Long menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(NotExistException::new)
                .getId();
    }

    public Long notEmptyOrderTableId(Long orderTableId) {
        final OrderTable persistOrderTable = orderTableRepository.findById(orderTableId)
                .orElseThrow(NotExistException::new);
        validateOrderTable(persistOrderTable);
        return persistOrderTable.getId();
    }

    private void validateOrderTable(OrderTable orderTable) {
        orderTable.validateEmpty();
    }
}

package kitchenpos.menu.domain;

import kitchenpos.menu.dto.MenuProductRequest;
import kitchenpos.menu.exception.IllegalMenuProductException;
import kitchenpos.product.domain.Product;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Embeddable
public class MenuProductGroup {
    private static final String EMPTY_ERROR_MESSAGE = "상품 메뉴는 비어있을 수 없습니다.";

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "menu_id", nullable = false, updatable = false)
    private final List<MenuProduct> menuProducts = new ArrayList<>();

    protected MenuProductGroup() {
    }

    private MenuProductGroup(List<MenuProduct> menuProducts) {
        validate(menuProducts);
        this.menuProducts.addAll(menuProducts);
    }


    private void validate(List<MenuProduct> menuProducts) {
        if (Objects.isNull(menuProducts) || menuProducts.isEmpty()) {
            throw new IllegalMenuProductException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static MenuProductGroup of(List<MenuProduct> menuProducts) {
        return new MenuProductGroup(menuProducts);
    }

    public List<MenuProduct> getMenuProducts() {
        return Collections.unmodifiableList(menuProducts);
    }

    public List<Long> getProductIds() {
        return menuProducts.stream()
                .map(MenuProduct::getProductId)
                .collect(Collectors.toList());
    }

    public BigDecimal calcTotalPrice(List<Product> products) {
        return menuProducts.stream()
                .map(menuProduct -> menuProduct.totalPrice(products))
                .reduce(BigDecimal::add)
                .orElseThrow(IllegalArgumentException::new);
    }
}

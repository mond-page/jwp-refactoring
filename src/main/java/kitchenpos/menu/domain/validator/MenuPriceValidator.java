package kitchenpos.menu.domain.validator;

import kitchenpos.menu.domain.Menu;

public interface MenuPriceValidator extends MenuCreateValidator {
    void validate(Menu menu);
}

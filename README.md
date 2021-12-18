# 키친포스

## 요구 사항

### 상품

- [ ] 이름과 가격을 통해 상품을 생성 할 수 있다.
  - [ ] 가격은 0 이상이어야 한다.
- [ ] 상품의 목록을 조회할 수 있다.

### 메뉴 그룹

- [ ] 이름을 통해 메뉴 그룹을 생성 할 수 있다.
- [ ] 목록을 조회 할 수 있다.

### 메뉴

- [ ] 메뉴의 이름, 가격과 메뉴 그룹의 아이디, 메뉴상품그룹을 통해 메뉴를 생성할 수 있다.
  - [ ] 메뉴 가격은 0보다 커야 한다.
  - [ ] 메뉴 그룹의 아이디에 따른 메뉴 그룹이 존재해야 한다.
  - [ ] 메뉴상품그룹의 메뉴 아이디에 따른 메뉴 상품의 상품이 존재해야 한다.
  - [ ] 메뉴의 가격은 포함된 구성된 상품들의 금액의 합 보다 작거나 같아야 한다.

- [ ] 메뉴의 목록을 조회 할 수 있다.

### 주문

- [ ] 주문테이블의 아이디, 주문 상태, 주문시간, 주문 항목 목록을 통해 주문을 생성 할 수 있다.
  - [ ] 주문 항목 목록은 비어 있을 수 없다.
  - [ ] 주문 항목 개수에 따른 존재하는 메뉴 개수가 서로 일치하지 않으면 생성할 수 없다.
  - [ ] 주문 테이블의 아이디를 따른 주문테이블이 존재해야 한다.
  - [ ] 주문 테이블이 빈 테이블가 아니어야 한다.
  - [ ] 주문상태가 조리로 변경된다.
  - [ ] 주문시간이 주문을 요청한 시간으로 변경된다.

- [ ] 주문 목록을 조회 할 수 있다.

- [ ] 주문 아이디를 통해 주문 상태를 변경할 수 있다.
  - [ ] 주문 아이디를 따른 주문이 존재해야 한다.
  - [ ] 주문 상태가 계산완료일 경우 변경 할 수 없다.

### 단체 지정

- [ ] 주문 테이블 목록을 통해 단체 지정을 생성 할 수 있다.
  - [ ] 주문 테이블은 최소 2개 이상이어야 한다.
  - [ ] 주문 테이블 목록 각각의 아이디를 따른 주문 테이블이 존재해야 한다.
  - [ ] 주문 테이블이 빈 테이블이 아니거나 단체 지정 아이디가 존재해야 한다.

- [ ] 단체 지정의 아이디를 통해서 단체 지정을 해제 할 수 있다.
  - [ ] 주문 테이블이 조리나 식사 상태일 경우 해제 할 수 없다.

### 주문 테이블

- [ ] 방문한 손님 수 와 빈 테이블 유무 주문 테이블을 생성 할 수 있다.
  - [ ] 주문 테이블이 생성시 단체 지정 아이디는 빈 값으로 변경된다.

- [ ] 주문 테이블 목록을 조회 할 수 있다.

- [ ] 주문 테이블 아이디와 주문 테이블을 통해 해당 주문 테이블을 빈 테이블로 변경할 수 있다.
  - [ ] 주문 테이블 아이디를 따른 주문 테이블이 존재해야 한다.
  - [ ] 단체 지정의 아이디가 빈값일 수 없다.
  - [ ] 주문 테이블의 상태가 조리나 식사 상태일 수 없다.

- [ ] 주문 테이블 아이디와 주문 테이블을 통해 해당 주문 테이블을 방문한 손님 수를 변경할 수 있다.
  - [ ] 방문한 손님 수를 1 이상으로 변경할 수 있다.
  - [ ] 주문 테이블의 아이디를 따른 주문 테이블이 존재해야 한다.
  - [ ] 빈 테이블이지 않아야 한다.

## 용어 사전

| 한글명      | 영문명                | 설명                            |
|----------|--------------------|-------------------------------|
| 상품       | product            | 메뉴를 관리하는 기준이 되는 데이터           |
| 메뉴 그룹    | menu group         | 메뉴 묶음, 분류                     |
| 메뉴       | menu               | 메뉴 그룹에 속하는 실제 주문 가능 단위        |
| 메뉴 상품    | menu product       | 메뉴에 속하는 수량이 있는 상품             |
| 메뉴 상품 그룹 | menu product group | 메뉴 상품 묶음                      |
| 금액       | amount             | 가격 * 수량                       |
| 주문 테이블   | order table        | 매장에서 주문이 발생하는 영역              |
| 빈 테이블    | empty table        | 주문을 등록할 수 없는 주문 테이블           |
| 주문       | order              | 매장에서 발생하는 주문                  |
| 주문 상태    | order status       | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests   | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정    | table group        | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목    | order line item    | 주문에 속하는 수량이 있는 메뉴             |
| 매장 식사    | eat in             | 포장하지 않고 매장에서 식사하는 것           |

## 모델링

에그리거트: 메뉴, 주문, 주문 테이블

## 메뉴 에그리거트

### 상품

- 상품은 아이디, 이름, 가격으로 구성되어 있다.
- 가격은 0보다 작을 수 없다.
- 이름과 가격은 빈값이 될 수 없다.

### 메뉴 그룹

- 메뉴 그룹은 아이디와 이름으로 구성되어 있다.
- 이름은 빈값이 될 수 없다.

### 메뉴 상품

- 메뉴 상품은 아이디, 메뉴의 아이디, 상품의 아이디, 수량을 가지고 있다.

### 메뉴 [ROOT]

- 메뉴는 이름, 가격, 메뉴 그룹의 아이디, 메뉴상품그룹으로 구성되어 있다.
- 가격은 0 이상이어야 한다.
- 가격은 포함된 구성된 상품들의 금액 보다 작거나 같아야 한다.

---

## 주문 에그리거트

### 주문 [ROOT]

- 주문은 아이디, 주문 테이블의 아이디, 주문 상태, 주문 시간, 주문 항목들로 구성되어 있다.

- 주문 시간은 주문 시점에 시간이다.
- 주문을 생성 될 때
  - 주문상태가 조리로 변경된다
  - 주문 테이블이 빈 테이블이 아니어야 한다.

#### 주문 상태

- 주문 상태는 조리, 식사, 계산 완료의 상태가 있다.
  - 조리: 주문 요청이 들어와 해당 주문의 음식을 만드는 단계
  - 식사: 만든 음식을 방문한 손님이 식사하는 단계
  - 계산 완료: 식사가 끝난 손님이 주문에 대해서 계산을 완료한 단계
- 주문 상태가 계산 완료일 경우 주문 상태를 변경 할 수 없다.

#### 주문 항목

- 주문 항목들은 아이디, 주문 아이디, 메뉴아이디, 수량으로 구성되어 있다.

---

## 주문 테이블 에그리거트

### 주문 테이블 [ROOT]

- 주문 테이블은 아이디, 단체 지정 아이디, 방문한 손님 수, 빈 테이블 유무로 구성되어 있다.
- 방문한 손님 수는 1명 이상이어야 한다.
- 주문 테이블 생성 시 단체 지정 아이디는 빈값이어야 한다.
- 주문 테이블의 주문 상태가 조리나 식사 상태일 경우가 아닐 경우 빈 테이블로 변경 가능하다.
- 빈 테이블이 아닐 경우 방문한 손님 수를 변경할 수 있다.

### 단체 지정

- 단체 지정은 아이디, 생성시간, 2개 이상의 주문 테이블로 구성되어 있다.
- 생성시간은 단체 지정이 생성될 때의 시간을 의미한다.
- 주문 테이블은 빈 테이블일 때 단체 지정을 생성 할 수 있다.
- 단체 지정은 조리나 식사 상태일 경우가 아닐 경우에만 해산 할 수 있다.

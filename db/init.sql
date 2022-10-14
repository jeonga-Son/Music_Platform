# 테스트 DB 생성
DROP DATABASE IF EXISTS app__2022_10_11__test;
CREATE DATABASE app__2022_10_11__test;
USE app__2022_10_11__test;

# 개발 DB 생성
DROP DATABASE IF EXISTS app__2022_10_11__dev;
CREATE DATABASE app__2022_10_11__dev;
USE app__2022_10_11__dev;

# 10월의 정산데이터를 만들기 위한 SELECT
SELECT *
FROM order_item
WHERE pay_date BETWEEN '2022-10-01 00:00:00.000000' AND '2022-10-31 23:59:59.999999'

# 주문품목당 정산해줘야 하는 금액
SELECT order_item_id,
pay_price,
refund_price,
wholesale_price,
pg_fee,
CASE
    WHEN pay_price = refund_price
    THEN 0
    ELSE pay_price - wholesale_price - pg_fee
END AS rebate_price
FROM rebate_order_item;
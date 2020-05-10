//장바구니 별로 물건의 합을 구해 출력하되, 금액이 50000 미만이면 배송료 3000원이 붙음


SELECT CART_ID,
    (
        CASE
        WHEN SUM(PRICE) < 50000 THEN SUM(PRICE) + 3000
        ELSE SUM(PRICE) END
    ) AS 결제액

FROM CART_PRODUCTS
GROUP BY CART_ID
ORDER BY CART_ID ASC;
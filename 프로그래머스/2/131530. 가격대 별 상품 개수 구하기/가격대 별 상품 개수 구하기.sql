-- 코드를 입력하세요
SELECT (PRICE DIV 10000)*10000 AS "PRICE_GROUP", COUNT(*) AS "PRODUCTS"
FROM PRODUCT
GROUP BY (PRICE DIV 10000)*10000
ORDER BY (PRICE DIV 10000)*10000;
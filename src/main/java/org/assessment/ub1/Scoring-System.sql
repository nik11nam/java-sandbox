/* Oracle SQL */
SELECT ID, NAME
FROM
(SELECT *
FROM STUDENT
ORDER BY SCORE DESC)
WHERE ROWNUM <= 3
ORDER BY SCORE DESC, ID ASC;
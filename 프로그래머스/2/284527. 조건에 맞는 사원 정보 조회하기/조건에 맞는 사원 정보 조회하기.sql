-- 코드를 작성해주세요
SELECT G.SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM HR_EMPLOYEES E JOIN (SELECT EMP_NO, SUM(SCORE) AS SCORE
                         FROM HR_GRADE
                         GROUP BY EMP_NO
                         ORDER BY SCORE DESC
                         LIMIT 1) G
ON E.EMP_NO = G.EMP_NO

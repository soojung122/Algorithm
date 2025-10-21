-- 코드를 작성해주세요
WITH avg_score AS (
SELECT
    EMP_NO,
    AVG(SCORE) AS avg_score
    FROM HR_GRADE
    WHERE YEAR = 2022
    GROUP BY EMP_NO
)
SELECT
    e.EMP_NO,
    e.EMP_NAME,
    CASE
        WHEN a.avg_score >= 96 THEN 'S'
        WHEN a.avg_score >= 90 THEN 'A'
        WHEN a.avg_score >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN a.avg_score >= 96 THEN e.SAL * 0.2
        WHEN a.avg_score >= 90 THEN e.SAL * 0.15
        WHEN a.avg_score >= 80 THEN e.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES AS e
INNER JOIN avg_score AS a
    ON e.EMP_NO = a.EMP_NO
ORDER BY e.EMP_NO;
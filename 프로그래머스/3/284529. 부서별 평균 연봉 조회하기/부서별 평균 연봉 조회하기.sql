select d.DEPT_ID, d.DEPT_NAME_EN, round(AVG(e.SAL)) AS AVG_SAL
 from HR_DEPARTMENT d
 join HR_EMPLOYEES e on d.DEPT_ID = e.DEPT_ID
 group by d.DEPT_ID
 order by AVG_SAL desc;
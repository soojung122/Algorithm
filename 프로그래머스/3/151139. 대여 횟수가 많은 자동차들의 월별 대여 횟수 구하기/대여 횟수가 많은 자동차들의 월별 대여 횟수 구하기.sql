select month(start_date) AS MONTH,
        CAR_ID, count(*) AS RECORDS
  from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
 WHERE start_date BETWEEN DATE '2022-08-01' AND DATE '2022-10-31'
   and  car_id in (select car_id
         from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where start_date between '2022-08-01' and '2022-10-31'
        group by car_id
       having count(*) >= 5)
 group by MONTH, CAR_ID
 order by MONTH asc, CAR_ID desc;
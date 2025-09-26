select distinct car_id, 
  case 
    when car_id in (select car_id
                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                   where '2022-10-16' between start_date and end_date)
        then '대여중'
        else '대여 가능'
END AS AVAILABILITY
 from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by car_id desc;

-- 대여중인 자동차
# select car_id
#   from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#  where '2022-10-16' between start_date and end_date
 
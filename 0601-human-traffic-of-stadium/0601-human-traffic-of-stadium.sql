with q1 as (
select *, id - row_number() over() as id_diff
from stadium
where people > 99
)
select id, visit_date, people
from q1
where id_diff in (
    select id_diff
    from q1 
    group by id_diff
    having count(*) > 2
    )
# order by visit_date


# my solution works on 10 testcases out of 14
# SELECT b.id, b.visit_date, b.people FROM(
    # SELECT *,
    # LEAD(people, 1, 0) OVER() AS next1Count,
    # LEAD(people, 2, 0) OVER() AS next2Count,
    # LAG(people, 1, 0) OVER() AS prev1Count,
    # LAG(people, 2, 0) OVER() AS prev2Count
    # FROM stadium
#     ) b
# WHERE (b.people >= 100 
#     AND b.next1Count >= 100
#     AND b.next2Count >= 100) OR
#     (b.people >= 100 
#     AND b.prev1Count >= 100
#     AND b.prev2Count >= 100)
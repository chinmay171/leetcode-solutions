WITH tempSeat AS(
  SELECT *,
  LEAD(student) OVER() AS next_student,
  LAG(student) OVER() AS prev_student
  FROM Seat
)

SELECT id, CASE WHEN MOD(id, 2) = 1 AND next_student IS NULL
                    THEN student
                WHEN MOD(id, 2) = 0 THEN prev_student
                ELSE next_student
           END AS student
FROM tempSeat;
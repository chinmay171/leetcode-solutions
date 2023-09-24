WITH FREQ AS (SELECT student_id, subject_name, 
COUNT(*) AS attended_exam
FROM examinations
GROUP BY student_id, subject_name)

SELECT st.student_id, st.student_name, sub.subject_name, 
CASE WHEN f.attended_exam IS NULL
     THEN 0
     ELSE f.attended_exam
END AS attended_exams
FROM (students st CROSS JOIN subjects sub)
      LEFT JOIN FREQ f
      ON (st.student_id = f.student_id
      AND sub.subject_name = f.subject_name)
ORDER BY st.student_id, sub.subject_name;
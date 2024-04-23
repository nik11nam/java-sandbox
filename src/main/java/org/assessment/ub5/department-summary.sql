-- Find no. of employees per department. Include department which doesn't have any employee
-- Show in descending order of no. of employee count. If same employee count then show the department alphabetically

-- 1.
SELECT DEPT_NAME, EMP_COUNT
FROM
(SELECT d.NAME DEPT_NAME, COUNT(e.id) EMP_COUNT
FROM
DEPARTMENT d LEFT OUTER JOIN EMPLOYEE e ON d.ID = e.DEPT_ID
GROUP BY DEPT_NAME)
ORDER BY EMP_COUNT desc, DEPT_NAME asc

-- 2.
SELECT DEPARTMENT.NAME, COUNT(EMPLOYEE.ID) AS EMP_COUNT
    FROM DEPARTMENT
    LEFT JOIN EMPLOYEE ON DEPARTMENT.ID = EMPLOYEE.DEPT_ID
    GROUP BY DEPARTMENT.NAME
    ORDER BY EMP_COUNT DESC, DEPARTMENT.NAME ASC
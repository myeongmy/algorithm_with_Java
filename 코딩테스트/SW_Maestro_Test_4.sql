SELECT STAGE, ROUND(AVG(STUDENT_NUM), 0), ROUND(AVG(STUDENT_NUM / TEACHER_NUM), 1) 
FROM SCHOOLS
GROUP BY STAGE
ORDER BY ROUND(SUM(STUDENT_NUM), 0) DESC, ROUND(AVG(STUDENT_NUM / TEACHER_NUM), 1) ASC;

//학교
// 초등학교, 중학교, 고등학교 별로 출력하는데 평균 학생 수는 소수점 첫째 자리에서 반올림, 평균 선생님 1명 당 학생 수는 소수점 둘째 자리에서 반올림한다.
// 출력 순서는 평균 학생 수를 기준으로 내림차순이고 평균 학생 수가 같은 경우 평균 선생님 1명 당 학생 수로 올림차순한다.
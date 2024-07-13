challenges:

SELECT *,ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS serial_no FROM Question where topic=:topic and difficulty_level=:difficultyLevel order by RAND() LIMIT :noOfQuestions
in the above query serial_no is coming only when topic/difficultylevel has value other than null..


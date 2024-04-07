# Leetcode
Collection of LeetCode questions to ace the coding interview! - Created using [LeetHub](https://github.com/QasimWani/LeetHub)

const getAllSolvedProblems = () => {
const LEETCODE_API_URL = 'https://leetcode.com/api/problems/algorithms';

const LEETCODE_PROBLEM_URL_PREFIX = "https://leetcode.com/problems/";

const xhr = new XMLHttpRequest();

/* Gather data */
var problems_data = [];

xhr.addEventListener('readystatechange', function () {
if (xhr.readyState === 4) {
let problems = JSON.parse(xhr.responseText)["stat_status_pairs"];
problems.forEach(problem => {
if(problem["status"] && problem["status"] === "ac")
{
var stat = problem["stat"];
let problem_data = {"title" : stat["question__title"], "url" : LEETCODE_PROBLEM_URL_PREFIX + stat["question__title_slug"], "id" : stat["frontend_question_id"]};
problems_data.push(problem_data);
}
});
console.log(problems_data[0]);
}
});

xhr.open('POST', LEETCODE_API_URL, true);
xhr.send();
};

//뒤에서 5등까지

//정렬 연습하기
//버블 소팅 연습

const arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
const result = [];

arr.forEach((value) => {
    result.push(value);
});

for (let i = 0; i < result.length - 1; i++) {
    for (let j = 0; j < result.length - i; j++) {
        const temp = result[j];
        if (result[j] > result[j + 1]) {
            result[j] = result[j + 1];
            result[j + 1] = temp;
        }
    }
}

function solution(num_list) {
    var answer = [];

    //소팅다시하기
    for (let i = 0; i < num_list.length - 1; i++) {
        for (let j = 0; j < num_list.length - i; j++) {
            const temp = num_list[j];
            if (num_list[j] > num_list[j + 1]) {
                num_list[j] = num_list[j + 1];
                num_list[j + 1] = temp;
            }
        }
    }
    for (let i = 0; i < 5; i++) {
        answer.push(num_list[i]);
    }

    return answer;
}

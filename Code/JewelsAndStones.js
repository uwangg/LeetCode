/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    let map = {};
    let sum = 0;
    
    for(let i = 0 ; i < S.length ; i++) {
        map[S[i]] = (!map[S[i]]) ? 1 : map[S[i]]+1;
    }
    
    for(let i = 0 ; i < J.length ; i++) {
        if(map[J[i]]) sum += map[J[i]];
    }
    
    return sum;
};
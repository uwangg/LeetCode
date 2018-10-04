/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    
    for( let i = 1 ; i < nums.length ; i++ ) {
    	nums[0] ^= nums[i];
    }

    return nums[0];
};

let nums = [2, 2, 1];
console.log( singleNumber(nums) );
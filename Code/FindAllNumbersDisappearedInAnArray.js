var findDisappearedNumbers = function(nums) {
    let result = [];
    let len = nums.length;

    for( let i = 0 ; i < len ; i++ ) {
        let idx = Math.abs(nums[i]) - 1;
    	nums[idx] = (nums[idx] > 0)? -nums[idx] : nums[idx];
    }

    for( let i = 0 ; i < len ; i++ ) {
    	if( nums[i] > 0 )
    	result.push(i + 1);
    }

    return result;
};

// test
let nums = [4, 3, 2, 7, 8, 2, 3, 1];
console.log( findDisappearedNumbers(nums) );
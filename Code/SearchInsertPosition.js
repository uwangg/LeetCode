/*
	35. Search Insert Position
	Solution : Binary Search
	O(logN)
*/
var searchInsert = function(nums, target) {
    var begin = 0 ;
    var end = nums.length - 1;

    if( nums[begin] >= target ) {
    	return 0;
    }

    if( nums[end] < target ) {
    	return end + 1;
    }

    while( (end - begin) > 1 ) {
    	var div = begin + Math.floor((end - begin) / 2);
    	if( nums[begin] < target && target <= nums[div] ) {
    		end = div;
    	} else {
    		begin = div;
    	}
    }
    return end;
};

var nums = [1, 3, 5, 6];
var target = 7;

console.log( searchInsert( nums, target ) );
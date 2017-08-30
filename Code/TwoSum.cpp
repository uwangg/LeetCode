/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
ex)
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
#include <iostream>
#include <vector>
using namespace std;
vector<int> twoSum(vector<int>& nums, int target) {
	vector<int> result;
	for (int i = 0; i < nums.size() ; i++) {
		for (int j = i + 1; j < nums.size(); j++) {
			if (target - nums[j] == nums[i]) {
				result.push_back(i);
				result.push_back(j);
				return result;
			}
		}
	}
	return result;
}
int main() {
	vector<int> v = { 2, 7, 11, 15 };
	int target = 9;
	vector<int> result = twoSum(v, target);
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << " ";
 	}
	return 0;
}

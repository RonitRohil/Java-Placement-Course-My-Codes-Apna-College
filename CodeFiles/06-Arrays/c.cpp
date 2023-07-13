#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <fstream>
#include <cstdlib>

int processArray(std::vector<int> &array) {

    int n = array.size();
    std::vector<int> ans;

    for(int i = 0; i < n; i++)
    {
        if (array[i] < 100)
        {
            ans.push_back(array[i]);
        }

        if(array[i] >= 100)
        {
            ans.push_back(array[i]);
            continue;
        }
    }

    return ans.size();
}

int main(void) {
  std::vector<int> array;
  int val;
  while (std::cin >> val) {
    if (val < 0) break;
    array.push_back(val);
  }
  int new_len = processArray(array);
  for(std::vector<int>::iterator a = array.begin(); a != array.end(); a++) {
    std::cout << *a << std::endl;
  }
  return 0;
}
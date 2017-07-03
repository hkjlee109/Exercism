#if !defined(ANAGRAM_H)
#define ANAGRAM_H

#include <string>
#include <vector>
#include <cstdbool>

using namespace std;

class anagram
{
private:
  string word;
  string word_sorted;
  bool is_anagram(string _test);

public:
  anagram(string _word);
  vector<string> matches(const vector<string> _tests);
};

#endif

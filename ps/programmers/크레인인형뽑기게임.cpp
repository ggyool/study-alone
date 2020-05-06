#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int n = board.size();
    vector<stack<int>> v(n);
    for(int i=n-1; i>=0; --i){
        for(int j=0; j<n; ++j){
            if(board[i][j] > 0){
                v[j].push(board[i][j]);
            }
        }
    }
    int ret = 0;
    vector<int> bracket;
    int len = moves.size();
    for(int i=0; i<len; ++i){
        int idx = moves[i] - 1;
        if(!v[idx].empty()){
            int newDoll = v[idx].top();
            v[idx].pop();
            bracket.push_back(newDoll);
            while(bracket.size()>=2 && bracket[bracket.size()-1]==bracket[bracket.size()-2]){
                ret+=2;
                bracket.pop_back();
                bracket.pop_back();
            }
        }
    }
    return ret;
}


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cout << 's';
    return 0;
}

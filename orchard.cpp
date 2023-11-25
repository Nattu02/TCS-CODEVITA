#include <iostream>
#include <cstring>

using namespace std;

int combination(char arr[], int n) {
    int orc = 0;
    string s = "";
    for (int i = 0; i < n; i++) {
        s = arr[i];
        for (int j = i + 1; j < n; j++) {
            s += arr[j];
            if (s[0] != arr[j]) {
                for (int k = j + 1; k < n; k++) {
                    if (s[1] != arr[k])
                        orc++;
                }
            }
            s = arr[i];
        }
    }
    return orc;
}

int main() {
    string ashok, anand;
    getline(cin, ashok);
    getline(cin, anand);

    char as[ashok.length()];
    char an[anand.length()];

    strcpy(as, ashok.c_str());
    strcpy(an, anand.c_str());

    int orc_as = combination(as, ashok.length());
    int orc_an = combination(an, anand.length());

    if (orc_as == 0 && orc_an == 0)
        cout << "Invalid input";
    else if (orc_as > orc_an)
        cout << "Ashok";
    else if (orc_an > orc_as)
        cout << "Anand";
    else
        cout << "Draw";

    return 0;
}

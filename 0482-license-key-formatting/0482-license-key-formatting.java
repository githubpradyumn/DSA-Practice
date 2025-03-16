class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String withoutHyphen = s.replaceAll("-", "");
        int n = withoutHyphen.length();
        int remainder = n % k;
        String res = "";
        if (remainder > 0) {
            res += withoutHyphen.substring(0, remainder) + "-";
        }
        for (int i = remainder; i + k <= n; i += k) {
            res += withoutHyphen.substring(i, i + k) + "-";
        }
        return res.toUpperCase().substring(0, res.length()!=0 ? res.length() - 1 : res.length());
    }
}
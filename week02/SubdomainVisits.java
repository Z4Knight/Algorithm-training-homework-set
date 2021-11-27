class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return ans;
        }

        Map<String, Integer> h = new HashMap<>();
        // com=9001, leetcode.com=9001;
        for (String cpdomain : cpdomains) {
            // 900 google.mail.com
            String[] cpinfo = cpdomain.split("\\s+");
            int viCnt = Integer.valueOf(cpinfo[0]);
            List<String> domains = getDomains(cpinfo[1]);
            for (String domain : domains) {
                int cnt = h.getOrDefault(domain, 0);
                h.put(domain, cnt + viCnt);
            }
        }

        for (Map.Entry<String, Integer> en : h.entrySet()) {
            ans.add(en.getValue() + " " + en.getKey());
        }
        return ans;
    }

    private int getVicnt(String cpdomain) {
        return Integer.parseInt(cpdomain.substring(0, cpdomain.indexOf(' ')));
    }

    private List<String> getDomains(String domain) {
        List<String> ans = new ArrayList<>();
        // google.mail.com
        // split by "\\." 就会得到: google, mail, com
        // com, mail.com, google.mail.com
        String str = "";
        String[] split = domain.split("\\.");
        for (int i = split.length - 1; i >= 0; i--) {
            if (i == split.length - 1) {
                str = split[i];
            } else {
                str = split[i] + "." + str;
            }
            ans.add(str);
        }
        return ans;
    }
}

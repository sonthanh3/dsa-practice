class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Bước 1: Đếm tần suất các ký tự trong chuỗi t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Cần bao nhiêu ký tự duy nhất thỏa mãn tần suất?
        int required = tMap.size();
        
        // Con trỏ trái, phải của cửa sổ trượt
        int left = 0, right = 0;
        
        // Đếm xem cửa sổ hiện tại đã thỏa mãn bao nhiêu ký tự duy nhất
        int formed = 0;
        
        // Map để lưu tần suất các ký tự trong cửa sổ hiện tại
        Map<Character, Integer> windowCounts = new HashMap<>();

        // res[0] lưu left, res[1] lưu right của cửa sổ tốt nhất tìm thấy
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        // Bước 2: Dịch chuyển con trỏ right để mở rộng cửa sổ
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Nếu ký tự này nằm trong `t` và đạt đủ số lượng yêu cầu
            if (tMap.containsKey(c) && windowCounts.get(c).equals(tMap.get(c))) {
                formed++;
            }

            // Bước 3: Thu hẹp cửa sổ bằng cách dịch left khi đã đủ điều kiện
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Cập nhật kết quả nếu tìm thấy cửa sổ nhỏ hơn
                if (right - left + 1 < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                // Ký tự ở con trỏ left chuẩn bị bị loại khỏi cửa sổ
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tMap.containsKey(c) && windowCounts.get(c) < tMap.get(c)) {
                    formed--;
                }

                // Dịch left sang phải
                left++;
            }

            // Dịch right sang phải để tiếp tục tìm kiếm
            right++;
        }

        // Bước 4: Trả về kết quả (Đoạn code bạn hỏi nằm ở đây)
        if (resLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(res[0], res[1] + 1);
        }
    }
}
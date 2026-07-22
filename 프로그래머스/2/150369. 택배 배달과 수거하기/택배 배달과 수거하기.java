class Solution {
    long cnt = 0;
    int[] Deliveries;
    int[] Pickups;
    int dIdx;
    int pIdx;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deliveries = deliveries.clone();
        Pickups = pickups.clone();
        dIdx = n - 1;
        pIdx = n - 1;

        while (pIdx >= 0 || dIdx >= 0) {

            while (dIdx >= 0 && Deliveries[dIdx] == 0) {
                dIdx--;
            }

            while (pIdx >= 0 && Pickups[pIdx] == 0) {
                pIdx--;
            }

            if (dIdx < 0 && pIdx < 0) {
                break;
            }

            int dLoca = farestHouse(cap);
            int pLoca = closestHouse(cap);
            cnt += (Math.max(dLoca, pLoca) + 1) * 2L;
        }

        return cnt;
    }

    int farestHouse(int cap) {
        while (dIdx >= 0 && Deliveries[dIdx] == 0) {
            dIdx--;
        }

        int location = dIdx;

        while (dIdx >= 0 && cap > 0) {
            if (Deliveries[dIdx] == 0) {
                dIdx--;
                continue;
            }

            int amount = Math.min(cap, Deliveries[dIdx]);

            Deliveries[dIdx] -= amount;
            cap -= amount;

            if (Deliveries[dIdx] == 0) {
                dIdx--;
            }
        }

        return location;
    }

    int closestHouse(int cap) {
        while (pIdx >= 0 && Pickups[pIdx] == 0) {
            pIdx--;
        }

        int location = pIdx;

        while (pIdx >= 0 && cap > 0) {
            if (Pickups[pIdx] == 0) {
                pIdx--;
                continue;
            }

            int amount = Math.min(cap, Pickups[pIdx]);

            Pickups[pIdx] -= amount;
            cap -= amount;

            if (Pickups[pIdx] == 0) {
                pIdx--;
            }
        }

        return location;
    }
}
from collections import deque

def solution(bridge_length, weight, truck_weights):
    seconds = bridge_length
    bridge = deque()

    # 최대 bridge_length대(초) / weight만큼 견딤
    
    bridge = deque([0] * bridge_length)
    idx = 0
    
    while truck_weights:
        if idx == len(truck_weights): break
        seconds += 1
        
        bridge.popleft()
        
        if sum(bridge) + truck_weights[idx] <= weight:
            bridge.append(truck_weights[idx])
            idx += 1        
        else:
            bridge.append(0)
    
    return seconds
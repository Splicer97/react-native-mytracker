
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNMytrackerSpec.h"

@interface Mytracker : NSObject <NativeMytrackerSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Mytracker : NSObject <RCTBridgeModule>
#endif

@end

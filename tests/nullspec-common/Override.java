// Copyright 2020 The JSpecify Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import org.jspecify.experimental.Nullable;
import org.jspecify.experimental.NonNull;

class Override {
  class Super {
    @NonNull Object foo(@NonNull Object p) { return ""; }
    @Nullable Object bar(@Nullable Object p) { return ""; }
  }

  class Good extends Super {
    @NonNull Object foo(@NonNull Object p) { return ""; }
    @Nullable Object bar(@Nullable Object p) { return ""; }
  }

  class Good2 extends Super {
    @NonNull Object bar(@Nullable Object p) { return ""; }
  }

  class Bad1 extends Super {
    // :: error: (override.return.invalid)
    @Nullable Object foo(@NonNull Object p) { return ""; }
  }
}

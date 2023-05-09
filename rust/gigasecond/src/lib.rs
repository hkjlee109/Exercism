use time::{PrimitiveDateTime, ext::NumericalDuration};

// Returns a DateTime one billion seconds after start.
pub fn after(start: PrimitiveDateTime) -> PrimitiveDateTime {
    start + 1e9.seconds()
}
